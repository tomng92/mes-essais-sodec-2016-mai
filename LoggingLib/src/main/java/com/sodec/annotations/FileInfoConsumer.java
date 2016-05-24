package com.sodec.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class FileInfoConsumer {
	@FileInfo(author = "Lokesh", version = "1.0")
	public String getString() {
		return null;
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		new FileInfoConsumer();
		Class<FileInfoConsumer> demoClassObj = FileInfoConsumer.class;
		readAnnotationOn(demoClassObj);
		Method method = demoClassObj.getMethod("getString", demoClassObj.getClasses());
		readAnnotationOn(method);
	}

	static void readAnnotationOn(AnnotatedElement element) {
		try {
			System.out.println("\n Finding annotations on " + element.getClass().getName());
			System.out.println("\n Finding annotations on " + element.toString());
			
			Annotation[] annotations = element.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof FileInfo) {
					FileInfo fileInfo = (FileInfo) annotation;
					System.out.println("Author :" + fileInfo.author());
					System.out.println("Version :" + fileInfo.version());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
