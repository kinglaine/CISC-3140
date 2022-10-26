#!/bin/bash

quiz = "2022-09-09"
Lab = "2022-09-27"
date = $(date)
date_diff=$((($date - $(date -d $quiz +%s)) / (60*60*24)))
echo "There are $date_diff between quiz1 and today "

