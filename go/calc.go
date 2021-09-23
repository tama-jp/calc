package calc

import (
	"fmt"
	"math"
	"strconv"
	"strings"
)

func count(slice *[]string) int {
	return len(*slice)
}

func push(slice *[]string, pushData string) {
	*slice = append(*slice, pushData)
}

func pop(slice *[]string) (error, string) {
	if len(*slice) == 0 {
		return nil, ""
	}

	popData := peek(slice)
	*slice = (*slice)[:len(*slice)-1] // 末尾削除
	return nil, popData
}

func peek(slice *[]string) string {
	return (*slice)[len(*slice)-1]
}

func numCheck(str string) bool {
	for _, r := range str {
		if '0' <= r && r <= '9' {
			return true
		}
	}
	return false
}

func convert(targetStr string) []string {
	key := [...]string{"*", "+", "-", "/", "(", ")", "sin", "cos", "tan", "sqrt", "log", "ln", "exp"}

	targetStrTemp := targetStr + ""
	targetStrTemp = strings.Replace(strings.ToLower(targetStrTemp), " ", "", -1)

	for _, s := range key {
		targetStrTemp = strings.Replace(strings.ToLower(targetStrTemp), s, " "+s+" ", -1)
		targetStrTemp = strings.Replace(strings.ToLower(targetStrTemp), "  ", " ", -1)
	}

	targetStrTemp = strings.Trim(targetStrTemp, " ")

	slice := strings.Split(targetStrTemp, " ")

	var buffer []string
	var stack []string

	for _, str := range slice {
		//fmt.Printf("[%s]", str)

		switch str {
		case "(", "sin", "cos", "tan", "sqrt", "log", "ln", "exp":
			push(&stack, str)
		case ")":
			for count(&stack) > 0 {
				_, pop := pop(&stack)
				if pop == "(" {
					break
				} else {
					push(&buffer, pop)
				}
			}

			if count(&stack) > 0 {
				peek := peek(&stack)

				if strings.EqualFold("sin", peek) ||
					strings.EqualFold("cos", peek) ||
					strings.EqualFold("tan", peek) ||
					strings.EqualFold("sqrt", peek) ||
					strings.EqualFold("log", peek) ||
					strings.EqualFold("ln", peek) ||
					strings.EqualFold("exp", peek) {
					_, pop := pop(&stack)
					push(&buffer, pop)
				}

			}
		case "*", "/":
			for count(&stack) > 0 {
				peek := peek(&stack)
				if strings.EqualFold("*", peek) ||
					strings.EqualFold("/", peek) {
					push(&stack, str)
				} else {
					break
				}
			}
			push(&stack, str)

		case "+", "-":
			for count(&stack) > 0 {
				peek := peek(&stack)
				if strings.EqualFold("*", peek) ||
					strings.EqualFold("/", peek) ||
					strings.EqualFold("+", peek) ||
					strings.EqualFold("-", peek) {
					push(&stack, str)
				} else {
					break
				}
			}
			push(&stack, str)
		default:
			push(&buffer, str)
		}

	}
	for count(&stack) > 0 {
		_, pop := pop(&stack)
		push(&buffer, pop)
	}
	return buffer
}

func calc(targetStr []string) string {
	var stack []string

	for _, str := range targetStr {
		switch str {
		case "+", "-", "*", "/":
			_, pop2 := pop(&stack)
			_, pop1 := pop(&stack)

			f1, _ := strconv.ParseFloat(pop1, 64)
			f2, _ := strconv.ParseFloat(pop2, 64)

			var a float64

			if str == "+" {
				a = f1 + f2
			} else if str == "-" {
				a = f1 - f2
			} else if str == "*" {
				a = f1 * f2
			} else if str == "/" {
				a = f1 / f2
			}

			data := fmt.Sprintf("%v", a)
			push(&stack, data)

		case "sin", "cos", "tan", "sqrt", "log", "ln", "exp":
			_, pop1 := pop(&stack)
			f1, _ := strconv.ParseFloat(pop1, 64)

			var a float64

			if str == "sin" {
				a = math.Sin(f1 * math.Pi / 180)
			} else if str == "cos" {
				a = math.Cos(f1 * math.Pi / 180)
			} else if str == "tan" {
				a = math.Tan(f1 * math.Pi / 180)
			} else if str == "sqrt" {
				a = math.Sqrt(f1)
				fmt.Printf("f1:%v", a)
			} else if str == "log" {
				a = math.Log10(f1)
			} else if str == "ln" {
				a = math.Log(f1)
			} else if str == "exp" {
				a = math.Exp(f1)
			}
			data := fmt.Sprintf("%v", a)
			push(&stack, data)

		default:
			if !numCheck(str) {
				panic("エラー")
			}

			push(&stack, str)
		}

	}
	_, pop := pop(&stack)
	return pop
}

func Convert(targetStr string) string {
	conv := convert(targetStr)
	return strings.Join(conv, " ")
}

func Answer(targetStr string) string {
	conv := convert(targetStr)
	answer := calc(conv)
	return answer
}
