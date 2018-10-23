# PDF_Read_SpringBoot

It requied Mongo DB for store data.

# Steps for run program
  1. Set diectorey in "Fileservice.java"
  2. Run SpringBoot App
  3. Use following REST API for result.
      1. localhost:8080/file/
          -> for loading All PDF files whi are present in given directory
      2. localhost:8080/file/{word}
          -> For searchinbg perticular word. Replace {word}.
