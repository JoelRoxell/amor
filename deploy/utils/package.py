# -*- coding: utf-8 -*-
from xml.dom.minidom import parse, parseString
from os.path import join, realpath, dirname

"""Loads pom.xml configuration
"""

# Load pom.xml
dir_name = dirname(realpath(__file__))

# Find artifact name and version.
packageDOM = parse(join(dir_name, '../../pom.xml'))
packageName = packageDOM.getElementsByTagName("artifactId")[0]
version = packageDOM.getElementsByTagName("version")[0] # first element notes the package version.

NAME = packageName.firstChild.nodeValue
VERSION = version.firstChild.nodeValue
