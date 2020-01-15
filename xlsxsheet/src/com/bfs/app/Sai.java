package com.bfs.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*Persose: To Read The Data Csv File using Io Lib ,Collections FrameWork 
 * ,Map FrameWork perofrm search operation Search Opertion
 * 
 */
public class Sai {
	static String s = new String("");

	public static void main(String[] args) throws Exception {
		// file class
		File file = new File("F:\\Bridgesoft\\ACME finance.csv");
		BufferedReader br;
		String line = "";
		String cvsSplitBy = ",";
		String[] stringArray = null;
		Scanner sc = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<>();
		// map to Store And to Search perpose
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		Map<String, Object> maps = new LinkedHashMap<>();

		int iteration = 0;
		br = new BufferedReader(new FileReader(file));
		while ((line = br.readLine()) != null) {
			// #To Skip the Frist Line
			if (iteration == 0) {
				s = line;
				iteration++;
				continue;
			}
			// use comma as separator
			stringArray = line.split(cvsSplitBy);
			list = CSVtoArrayList(line);
			System.out.println("listtt"+list);
			map.put(stringArray[0], list);

		}
		// condition to check
		System.out.println("enter id ");
		String id = sc.next();
		sc.close();
		List<String> liste = map.get(id);
		List<String> groupmgr = getEmpIdAccesses(id);
		System.out.println("bcxmnnx:"+groupmgr);
		String w = groupmgr.toString();
		String s = liste.get(5);
		String[] strS = s.split("=");
		String s1 = strS[0] + "=" + w;
		liste.remove(5);
		liste.add(5, s1);
		map.put(stringArray[0], liste);

		for (Map.Entry<String, List<String>> values : map.entrySet()) {
			maps.put(values.getKey(), values);
		}
		// Map<String, Object> Maplist = mapTOFilter(maps, id);
		// System.out.println(Maplist);
		System.err.println(maps.get(id));
		// close coslty operations
		br.close();
		
	}
	
	public static List<String> getEmpIdAccesses(String id) throws Exception {

		String line = "";
		String cvsSplitBy = ",";
		BufferedReader br = null;

		Map<String, List<String>> map = new LinkedHashMap<>();
		List<String> list = null;
		File file = new File("F:\\Bridgesoft\\ACME finance.csv");
		br = new BufferedReader(new FileReader(file));
		int iteration = 0;
		String[] stringArray = null;

		while ((line = br.readLine()) != null) {
			// #To Skip the First Line
			if (iteration == 0) {

				iteration++;
				continue;
			}
			// use comma as separator
			stringArray = line.split(cvsSplitBy);
			//CsvToMap(line, id);
			// checking the key To Insert Key Value as Map
			if (map.containsKey(stringArray[0])) {
				list = map.get(stringArray[0]);
				// System.out.println(list);
				list.add(stringArray[5]);

				map.put(id, list);

			} else {
				List<String> arryList = new ArrayList<>();
				arryList.add(stringArray[5]);

				map.put(stringArray[0], arryList);
			}

		}
		List<String> ll = map.get(id);
		br.close();
		// System.out.println(map);
		return ll;

	}

	@SuppressWarnings("unchecked")
	/*public static Map<String, Object> mapTOFilter(Map<String, Object> maps, String id) {

		Map<String, Object> listesMap = maps.entrySet().stream().filter(m -> {
			return Pattern.matches("^[0-9]*[1-9][0-9]*$", id) & m.getKey().equals(id);
		}).map(m -> m.getValue()).collect(Collectors.toMap((entry) -> ((Entry<String, List<String>>) entry).getKey(),
				entry -> ((Entry<String, List<String>>) entry).getValue()));
		// System.out.println(listesMap);
		return listesMap;

	}*/

	// To Save The Values In TO Map
	/*public static Map<String, String> CsvToMap(String csv, String id) throws Exception {
		Map<String, String> map = new LinkedHashMap<>();
		if (csv != null) {
			String[] splitData = csv.split("\\s*,\\s*");
			String[] headerData = s.split("\\s*,\\s*");
			int i;

			int i1 = 0;

			for (i = 0; i < splitData.length; i++) {

				map.put(headerData[i1], splitData[i1]);

				i1++;

			}
			//System.out.println(map.get(id));
			//System.out.println("csvtomap:"+map);
			/*
			 * Tried to Execute But It Coudent
			 * 
			 
			// List<String> l = getEmpIdAccesses(id);

			// map.replace("groupmbr", l.toString());
		}
		// System.out.println(map);
		return map;

	}*/

	// To Store The Values in ArrayList
	public static ArrayList<String> CSVtoArrayList(String cSV) {
		ArrayList<String> list = new ArrayList<String>();
		// Map<String, String> map = new LinkedHashMap<>();

		if (cSV != null) {
			String[] splitData = cSV.split("\\s*,\\s*");
			String[] headerData = s.split("\\s*,\\s*");
			int i;

			int i1 = 0;

			for (i = 0; i < splitData.length; i++) {

				list.add(headerData[i1] + "=" + splitData[i1].trim());
				// map.put(headerData[i1], splitData[i1]);

				i1++;

			}

		}
		// System.out.println(map);
		return list;
	}

}
