# POC Doc generation HTML -> PDF

## Step 1

See src/main/resources/Roboto-Regular.ttf

```HTML
<body style="font-family: Roboto;">
é"'(-è_çà
</body>
```

## Step 2

Add Roboto-Regular.ttf to your resource

```JAVA
ITextRenderer renderer = new ITextRenderer();
renderer.getFontResolver().addFont(Main.class.getResource("/Roboto-Regular.ttf").toExternalForm(), true);

renderer.setDocumentFromString(html);
renderer.layout();
renderer.createPDF(outputStream);
outputStream.close();
```

## Step 3 load the resource and get an absolute path to be able to use it from other jar

## Tested

This has been tested from a docker container without any font file (based on centos 7) and it works !
It's very important to set font family in html, else i got some squares...

## What didn't worked

Installing microsoft fonts in the container didn't fixed the issue while they are the default one in itext library and correctly loaded !
Loading the font is not enough but I had to debug to find the correct family name interpreted by Itext from font file.
If you misspelled Roboto, (eg roboto) it is not working
