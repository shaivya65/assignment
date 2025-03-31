#!/usr/bin/env python3

import cgi

# Get form data
form = cgi.FieldStorage()
username = form.getvalue("username", "Guest")

# Print response (like HTTP headers)
print("Content-type: text/html\n")
print(f"<html><body><h2>Welcome, {username}!</h2></body></html>")
