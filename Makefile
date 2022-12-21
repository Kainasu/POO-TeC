SRC_DIR = src
BUILD_DIR = build
TEST_DIR = tst

SRC_FILES = $$(find ${SRC_DIR} -name '*.java')
SRC_EXEC = Simple

TEST_FILES = $$(find ${TEST_DIR} -name '*.java')
TEST_EXEC = $$(find ${BUILD_DIR} -name 'Test*.class' -exec basename {} \; | cut -d. -f1)

PACKAGE_NAME = tec

all: exec

alltest:
	javac -d ${BUILD_DIR} ${SRC_FILES}
	javac -d ${BUILD_DIR} -cp ${BUILD_DIR} ${TEST_FILES}
	for e in ${TEST_EXEC} ; do \
		java -ea -cp ${BUILD_DIR} ${PACKAGE_NAME}.$$e ; \
	done

exec:
	javac -d ${BUILD_DIR} ${SRC_FILES}
	java -cp ${BUILD_DIR} ${SRC_EXEC}

clean:
	rm -rf ${BUILD_DIR}/*.class

testJauge:
	javac -d ${BUILD_DIR} ${SRC_DIR}/Jauge.java ${TEST_DIR}/TestJauge.java
	java -ea -cp ${BUILD_DIR} ${PACKAGE_NAME}.TestJauge 

autobus:
	javac -d ${BUILD_DIR} ${SRC_DIR}/Jauge.java ${SRC_DIR}/Autobus.java ${SRC_DIR}/Passager.java ${SRC_DIR}/Vehicule.java 

testAutobus: autobus
	javac -d ${BUILD_DIR} -cp ${BUILD_DIR} ${TEST_DIR}/FauxPassager.java ${TEST_DIR}/TestAutobus.java
	java -ea -cp ${BUILD_DIR} ${PACKAGE_NAME}.TestAutobus

testPosition:
	javac -d ${BUILD_DIR} ${SRC_DIR}/Position.java ${TEST_DIR}/TestPosition.java
	java -ea -cp ${BUILD_DIR} ${PACKAGE_NAME}.TestPosition 

PassagerStandard:
	javac -d ${BUILD_DIR} ${SRC_DIR}/Position.java ${SRC_DIR}/PassagerStandard.java ${SRC_DIR}/Passager.java ${SRC_DIR}/Vehicule.java 

testPassagerStandard: PassagerStandard
	javac -d ${BUILD_DIR} -cp ${BUILD_DIR} ${TEST_DIR}/FauxVehicule.java ${TEST_DIR}/TestPassagerStandard.java
	java -ea -cp ${BUILD_DIR} ${PACKAGE_NAME}.TestPassagerStandard
