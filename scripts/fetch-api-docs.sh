#!/usr/bin/env bash

#
# Need services launched
##########################
#

# user
curl -fsSL http://localhost:8080/v3/api-docs.yaml > library/src/main/resources/user.yml

# question
curl -fsSL http://localhost:8081/v3/api-docs.yaml > library/src/main/resources/question.yml

# leaderboard
curl -fsSL http://localhost:8082/v3/api-docs.yaml > library/src/main/resources/leaderboard.yml
