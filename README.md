# Compsci Learning Experiments (Java)

**Author:** Xano Sweeting
**License:** MIT
**Created:** 2019-10-02

## Setup

Make sure you have Homebrew and Java installed.
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
brew cask install java
```

## Running code

Compile and run files in this project like this.
```bash
javac ExampleFile.java && java ExampleFile
```

## Code Style

First install the linting tool [`prettier` for Java](https://github.com/jhipster/prettier-java).
```bash
brew install node
npm i -g lodash prettier prettier-plugin-java
```

Then have it automatically fix styling errors in code files.
```bash
prettier --tab-width 4 --write ExampleFile.java
```

## Tools & Editor Plugins

For Sublime Text 3, the following plugins make Java development a lot more pleasant:

- https://packagecontrol.io/packages/TabNine (awesome all-language autocomplete)
- https://packagecontrol.io/packages/JavaIME (Java-specific autocomplete)
- https://packagecontrol.io/packages/sublimelint (General linter package needed for all languages)
- https://packagecontrol.io/packages/SublimeLinter-javac (check for errors automatically on save)
- https://packagecontrol.io/packages/Display%20Functions%20(Java) (show function info in autocomplete box)
- https://packagecontrol.io/packages/JavaSetterGetter (autogenerate getter and setter methods for classes)
- https://packagecontrol.io/packages/All%20Autocomplete (autocomplete text from all files)
- https://packagecontrol.io/packages/FileSystem%20Autocompletion (autocomplete filenames and paths)
- https://packagecontrol.io/packages/GoToClass (jump to a class definition quickly)
- https://packagecontrol.io/packages/Goto%20Usage (reverse find where a class/method are being used)
- https://packagecontrol.io/packages/SublimeGit (awesome Git integration features)

<img src="https://i.imgur.com/PqAMQz1.png" width="400px"/>

Some other useful tools for development:

- https://www.sublimemerge.com/ (Git desktop app)
- https://desktop.github.com/ (Git desktop app)
- https://www.jetbrains.com/idea/ (powerful Java IDE with lots of features)


## Documentation & Resources

### Beginner Docs

- https://learnxinyminutes.com/docs/java/ (Quick reference docs)
- https://www.javatpoint.com/java-tutorial (intro-level docs with lots of examples)
- https://www.tutorialspoint.com/java/java_basic_syntax.htm (intro-level docs with lots of info)
- https://www.programiz.com/java-programming (intro walkthrough tutorial)

### Advanced Docs

- https://devdocs.io/openjdk/ (full API reference docs with nice search)
- https://docs.oracle.com/en/java/javase/13/docs/api/index.html (full API reference docs)
- https://docs.oracle.com/javase/tutorial/java/index.html (more resources)

### Example Code

- https://www.w3schools.com/java/java_examples.asp
- https://www.cs.utexas.edu/~scottm/cs307/codingSamples.htm
- https://www.programiz.com/java-programming/examples
- https://beginnersbook.com/2017/09/java-examples/

### Online Editors & Testers

- https://repl.it/languages/java10 (online Java editor for testing quick snippets)
- https://www.onlinegdb.com/online_java_debugger (online Java editor with debugging features)
