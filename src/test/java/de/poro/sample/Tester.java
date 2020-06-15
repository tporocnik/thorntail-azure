package de.poro.sample;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

public class Tester {

	// Check if the first entry in the jar is the manifest. Windows Zip will keep
	// order of adding files. 7zip is reordering all the time
	public static void main(String[] args) {
		try {
			InputStream file = new FileInputStream("target/tmp/test-thorntail-thorntail.jar");
			try (JarInputStream jarFile = new JarInputStream(file)) {
				Manifest manifest = jarFile.getManifest();
				JarEntry jarEntry;
				while (true) {
					jarEntry = jarFile.getNextJarEntry();
					if (jarEntry == null) {
						break;
					}
					System.out.println("Found " + jarEntry.getName().replaceAll("/", "\\."));
				}
				System.out.println(Objects.requireNonNull(manifest));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
