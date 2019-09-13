---
layout: default
title: Console Kihon
---
```java
@Override
protected void writeFooBarToTheConsole() {
    System.out.print("FooBar");
}

@Override
protected void writeLineFooBarToTheConsole() {
    System.out.println("FooBar");
}

@Override
protected String readLineFromConsoleAndReturnValue() {
    return new Scanner(System.in).nextLine();
}
```
