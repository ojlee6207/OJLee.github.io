package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

// FileRenamePolicy 인터페이스를 구현
public class MyFileRenamePoilcy implements FileRenamePolicy {
	// rename 메소드 재정의
	// => 파일명 수정 후 수정된 파일을 반환하는 메소드
	@Override
	public File rename(File originFile) {
		
		// 원본 파일명 (test.jpg)
		String originName = originFile.getName();
		
		// => 수정할 파일명("*202403220921xxxxx.jpg") : 파일 업로드 시간(년월일시분초) + 5자리 랜덤값(10000~99999)+원본 파일의 확장자
		
		// 1) 파일 업로드 시간
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		// 2) 5자리 랜덤값 
		int randNum = (int)(Math.random()*90000)+10000;
		
		// 3) 원본 파일의 확장자
		//	  문자열.substring(마지막 dot의 위치)
		String ext = originName.substring( originName.lastIndexOf(".") ); // => .jpg
		
		String changeName = currentTime + randNum + ext;
		
		return new File(originFile.getParent(), changeName); // new File(원본파일 디렉토리, 변경할 파일명)
	}
}
