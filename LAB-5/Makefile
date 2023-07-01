
all: src/AppMain.java 
	cd src &&\
	javac  -d Classes -Xlint:unchecked -Xdiags:verbose -Xlint:deprecation *.java &&\
	cd Classes &&\
	java Main

clean: 
	cd Classes  &&  rm -rf *.class && rm -rf Principal/Main
