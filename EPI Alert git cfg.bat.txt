@echo off
git init
git remote add origin https://github.com/yvesemmad/epialert.git
git fetch origin
git checkout -b adamdjigbe origin/adamdjigbe
git pull
git status