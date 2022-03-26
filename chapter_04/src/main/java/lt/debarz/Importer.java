package lt.debarz;

import java.io.File;
import java.io.IOException;

/**
* We have a couple of different options: use a plain String to represent the path
 * of the file, or use a class that represents a file, like java.io.File.
 * You could make the case that we should apply the principle of strong
 * typing here: take a type that represents the file and reduce the scope
 * for errors versus using a String. Let’s take that approach and use a
 * java.io.File object as the parameter in our Importer
 * interface to represent the file being imported
* */
public interface Importer {
    Document importFile(File file) throws IOException;
}
