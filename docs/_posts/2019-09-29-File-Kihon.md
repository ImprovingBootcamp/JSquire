---
layout: default
title: File Kihon
---

```java
@Override
public String getContentsOfThisFile(Path pathOfFile) throws IOException {
    return Files.readString(pathOfFile);
}

@Override
public void writeContentsToThisFile(Path pathOfFile, String contents) throws IOException {
    Files.writeString(pathOfFile, contents);
}
```
