#!/usr/bin/env bash

SRC_DIR=./src/main/java
TEST_SRC_DIR=./src/test/java
TEST_RESOURCE_DIR=./src/test/resources
ROOT_PACKAGE=uk/co/mrdaly/adventofcode2021
QUALIFIED_PACKAGE=${ROOT_PACKAGE//\//.}

while getopts n: flag
do
  case "${flag}" in
    n) puzzle_name=${OPTARG};;
  esac
done

next_puzzle_number=$(ls $SRC_DIR/$ROOT_PACKAGE | grep -c "^_")
((next_puzzle_number=next_puzzle_number+1))

if [[ ${#next_puzzle_number} == 1 ]]
then
  next_puzzle_number=0$next_puzzle_number
fi

package_name=_$next_puzzle_number$puzzle_name
package_root=$ROOT_PACKAGE/$package_name

src="$SRC_DIR/$package_root"
test="$TEST_SRC_DIR/$package_root"
res="$TEST_RESOURCE_DIR/$package_name"

mkdir "$src"
mkdir "$test"
mkdir "$res"

src_file="$src/$puzzle_name.java"

touch "$src_file"

echo -e "package ${QUALIFIED_PACKAGE}.$package_name;""\r\n""public class ${puzzle_name} {""\r\n\r\n""}" >> "$src_file"

test_file=$test/${puzzle_name}Test.java

echo -e "package ${QUALIFIED_PACKAGE}.$package_name;""\r\n""public class ${puzzle_name}Test {""\r\n\r\n""}" >> "$test_file"

res_file=$res/${next_puzzle_number}input1.txt

touch "$res_file"