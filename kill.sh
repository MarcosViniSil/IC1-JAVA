#!/bin/bash
PORT_NUMBER="$1"
sudo fuser -k "$PORT_NUMBER"/tcp
