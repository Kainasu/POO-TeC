SRC_DIR = src
BUILD_DIR = build
TEST_DIR = tst

SRC_FILES = $$(find ${SRC_DIR} -name '*.java')
SRC_EXEC = Simple

TEST_FILES = $$(find ${TEST_DIR} -name '*.java')
TEST_EXEC = $$(find ${BUILD_DIR} -name 'Test*.class' -exec basename {} \; | cut -d. -f1 | grep -v -e "Abstrait" -e "Montee" -e "Arret" | sed 's/^/${PACKAGE_NAME}./g')

PACKAGE_NAME = tec

all: exec

alltest:
	javac -d ${BUILD_DIR} ${SRC_FILES}
	javac -d ${BUILD_DIR} -cp ${BUILD_DIR} ${TEST_FILES}
	java -ea -cp ${BUILD_DIR} ${PACKAGE_NAME}.LancerTests ${TEST_EXEC} ;

exec:
	javac -d ${BUILD_DIR} ${SRC_FILES}
	java -cp ${BUILD_DIR} ${SRC_EXEC}

collecteEstUn:
	javac -d ${BUILD_DIR} ${SRC_FILES}
	java -cp ${BUILD_DIR} SimpleCollecteEstUn

clean:
	rm -rf ${BUILD_DIR}/*
