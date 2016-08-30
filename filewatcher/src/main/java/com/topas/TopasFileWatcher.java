/*
 * Sodacces, Société de développement des entreprises culturelles (SODEC).
 *
 * TODO Incrire ici toutes informations sur les droits d'utilisation et de modification 
 * des compostantes du système Sodacces.
 */

package com.topas;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * @author tnguyen 2016-08-03
 * @version 1.0
 *
 */
public class TopasFileWatcher {

	/**
	 * @throws InterruptedException 
	 * @throws IOException 
	 * 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		
		final Path path = FileSystems.getDefault().getPath(System.getProperty("user.home"), "Desktop");
		System.out.println(path);
		
		try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
			final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY );
			while (true) {
				final WatchKey wk = watchService.take();
				for (WatchEvent<?> event : wk.pollEvents()) {
					// we only register "ENTRY_MODIFY" so the context is always
					// a Path.
					final Path changed = (Path) event.context();
					System.out.println(changed);
					if (changed.endsWith("myFile.txt")) {
						System.out.println("My file has changed");
					}
				}
				// reset the key
				boolean valid = wk.reset();
				if (!valid) {
					System.out.println("Key has been unregisterede");
				}
			}
		}
	}

}
