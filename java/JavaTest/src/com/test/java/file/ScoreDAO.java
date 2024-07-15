package com.test.java.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

//~DAO, Data Access Object)
//~Repository(데이터 저장소)
public class ScoreDAO {
	private final String PATH = ".\\dat\\score.txt";

//	public void add(String name, int kor, int eng, int math) {
//		
//	}

	public void add(ScoreDTO dto) {
		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));		//Create 모드
			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true));	//Append 모드
			
			String line = String.format("%s,%d,%d,%d\r\n", 
					dto.getName(), dto.getKor(), dto.getEng(), dto.getMath());
			
			writer.write(line);	//성적 추가
			writer.close();
		} catch (Exception e) {
			System.out.println("ScoreDAO.add");
			e.printStackTrace();
		}
	}

	public ScoreDTO get(String name) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				if(line.startsWith(name)) {
					String[] temp = line.split(",");
					ScoreDTO dto = new ScoreDTO();
					dto.setName(temp[0]);
					dto.setKor(Integer.parseInt(temp[1]));
					dto.setEng(Integer.parseInt(temp[2]));
					dto.setMath(Integer.parseInt(temp[3]));
					return dto;
				}
			}
			
		} catch (Exception e) {
			System.out.println("ScoreDAO.get");
			e.printStackTrace();
		}
		return null;
	}

	public void edit(ScoreDTO dto) {
		try {
//			기존 점수 > 수정
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			String line = null;
			String temp = "";	//누적 변수
			
			while((line = reader.readLine()) != null) {
				if(!line.startsWith(dto.getName())) {
					temp += line + "\r\n";
				} else {
					temp += String.format("%s,%d,%d,%d\r\n", 
							dto.getName(), dto.getKor(), dto.getEng(), dto.getMath());
				}
			}
			
			reader.close();
			
//			수정된 내용 > 덮어쓰기
			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));
			writer.write(temp);
			
			writer.close();
		} catch (Exception e) {
			System.out.println("ScoreDAO.edit");
			e.printStackTrace();
		}
	}

	public void remove(ScoreDTO dto) {
		try {
//			기존 점수 > 수정
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			String line = null;
			String temp = "";	//누적 변수
			
			while((line = reader.readLine()) != null) {
				if(!line.startsWith(dto.getName())) {
					temp += line + "\r\n";
				}
			}
			
			reader.close();
			
//			수정된 내용 > 덮어쓰기
			BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));
			writer.write(temp);
			
			writer.close();
		} catch (Exception e) {
			System.out.println("ScoreDAO.remove");
			e.printStackTrace();
		}
	}

}
