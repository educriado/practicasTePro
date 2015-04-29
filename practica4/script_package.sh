#!/bin/bash
#Quitar package de los fuentes.
for file in `ls`
do
	sed -i '/package practica4;/d' $file

done
