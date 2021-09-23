#!/usr/bin/env bash
go mod init club.kodawari.calc
# go get -u golang.org/x/mobile/bind
go get golang.org/x/mobile/cmd/gomobile
gomobile bind -o ../calc/app/libs/calc.aar -target=android club.kodawari.calc
