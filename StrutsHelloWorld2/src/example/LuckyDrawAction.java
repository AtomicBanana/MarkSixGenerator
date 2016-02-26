package example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LuckyDrawAction extends Action {
	
	private int[] drawResult = new int[6];
	private int[] numbers_array = new int[6];
	private int matched_count = 0;
	private int records = 5000;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
 			HttpServletRequest request, HttpServletResponse response)
 					throws IOException, ServletException {
		String target = "failure";
		String numbers = null;
		
		if ( form != null ) {
			LuckyDrawForm luckyDrawForm = (LuckyDrawForm)form;
			numbers = luckyDrawForm.getNumbers();
		}
		if(isNumbersValid(numbers)){
			request.setAttribute("numbers", numbers);
			target = "success";
			drawNumbers(1, 49);
			for(int i = 0; i < drawResult.length; i++){
				request.setAttribute("numbers" + String.valueOf(i + 1), drawResult[i]);
			}
			
			int[][] drawsTable = new int[records][];
			int[] hitCounts = new int[records];
			for(int i = 0; i < drawsTable.length ; i++){
				int[] draws = drawNumbers2(1,49);
				boolean passAllValidation = false;
				while(!passAllValidation){
					if(isMissingOneDoor(draws) &&
							isMoreThan1Odd(draws) &&
							!isMoreThan3ConsequencNo(draws) &&
							isSumBetween140And210(draws) &&
							!isAppearedPreviously(request.getServletContext().getRealPath("WEB-INF\\history.txt"), draws) &&	
							!unluckyNoExist(request.getServletContext().getRealPath("WEB-INF\\unluckyNo.txt"), draws)) {
						passAllValidation = true;
					} else {
						passAllValidation = false;
						draws = drawNumbers2(1,49);
					}
				}
				drawsTable[i] = draws;
				hitCounts[i] = countHits(drawResult, draws);
			}
			request.setAttribute("drawsTable", drawsTable);
			//request.setAttribute("draws", draws);
			request.setAttribute("hits", hitCounts);
			request.setAttribute("hitAvg", avgHitRate(hitCounts));
			int max = maxHit(hitCounts);
			request.setAttribute("maxHit", max);
			request.setAttribute("maxCount", countMax(max, hitCounts));
			
		}
		return (mapping.findForward(target));
	}
	
	public boolean isNumbersValid(String numbers){
		//1. if there are 6 numbers
		String[] num_ary = null;
		if(numbers == null){
			return false;
		} else {
			num_ary = numbers.split(",");
		}
		
		if(num_ary.length != 6){
			return false;
		}
		
		for(int i = 0; i < num_ary.length; i++){
			int num = 0;
			//1. check if within 1 ~ 48
			try{
				num = Integer.parseInt(num_ary[i]);
				
				if(num < 1 || num > 49){
					return false;
				}
			} catch (NumberFormatException e){
				return false;
			}
			//2. check if duplicated
			for(int k = i + 1; k<num_ary.length; k++){
				if(num_ary[i].equals(num_ary[k])){
					return false;
				}
			}
			numbers_array[i] = num;
		}
		return true;
	}
	
	private void drawNumbers(int Min, int Max){
		
		for(int i = 0; i < drawResult.length; i++){
			int drawNum = 0;
			boolean isDuplicated = true;
			
			while(isDuplicated){
				isDuplicated = false;
				drawNum = Min + (int)(Math.random() * ((Max - Min) + 1));
				for(int k = 0; k < drawResult.length; k++){
					if(drawNum == drawResult[k]){
						isDuplicated = true;
					}
				}
			}
			drawResult[i] = drawNum;
		}
	}
	
	private int[] drawNumbers2(int Min, int Max){
		
		int[] draws = new int[6];
		
		for(int i = 0; i < draws.length; i++){
			int drawNum = 0;
			boolean isDuplicated = true;
			
			while(isDuplicated){
				isDuplicated = false;
				drawNum = Min + (int)(Math.random() * ((Max - Min) + 1));
				for(int k = 0; k < draws.length; k++){
					if(drawNum == draws[k]){
						isDuplicated = true;
					}
				}
			}
			draws[i] = drawNum;
		}
		
		return draws;
	}
	
	public boolean isMissingOneDoor(int[] draws){
		//Arrays.sort(draws);
		Hashtable<String, Integer> h1 = new Hashtable();
		h1.put("oneToTen", 0);
		h1.put("elevenToTwenty", 0);
		h1.put("twentyOneToThridty", 0);
		h1.put("thridtyOneToForty", 0);
		h1.put("fortyOneToFortyNine", 0);
		
		for(int i = 0; i < draws.length; i++){
			int draw = draws[i];
			if(draw > 40){
				h1.put("fortyOneToFortyNine", h1.get("fortyOneToFortyNine") + 1);
			} else if(draw <= 40 && draw > 31){
				h1.put("thridtyOneToForty", h1.get("thridtyOneToForty") + 1);
			} else if(draw <= 30 && draw > 21){
				h1.put("twentyOneToThridty", h1.get("twentyOneToThridty") + 1);
			} else if(draw <= 20 && draw > 11){
				h1.put("elevenToTwenty", h1.get("elevenToTwenty") + 1);
			} else{
				h1.put("oneToTen", h1.get("oneToTen") + 1);
			}
		}
		
		if(h1.containsValue(0)){
			return true;
		}
		
		return false;
	}
	
	// check if more than 1 odd and not 6 odd
	public boolean isMoreThan1Odd(int[] draws){
		int numOfOdd = 0;
		for(int i = 0; i < draws.length; i++){
			int draw = draws[i];
			if(draw % 2 == 1){// it is odd
				numOfOdd++;
			}
		}
		if(numOfOdd > 1 && numOfOdd < 6){
			return true;
		}
		return false;
	}
	
	// check if more than 3 consequence no.
	public boolean isMoreThan3ConsequencNo(int[] draws){
		Arrays.sort(draws);
		for(int i = 0; i < draws.length - 3; i++){
			int draw = draws[i];
			if(draws[i+1] == draw + 1 &&
				draws[i+2] == draw + 2 &&
				draws[i+3] == draw + 3){
				return true;
			}
		}
		return false;
	}
	
	// check if sum between 140 and 210
	public boolean isSumBetween140And210(int[] draws){
		int sum = 0;
		for(int i = 0; i < draws.length; i++){
			sum += draws[i];
		}
		
		if(sum >= 140 && sum <= 210){
			return true;
		}
		return false;
	}
	
	private boolean checkMuitl(int[] draws){
		return false;
	}
	
	public boolean checkPattern1(int[] draws){
		return false;		
	}
	
	public boolean isAppearedPreviously(String filePath, int[] draws){
		try{
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();
			Arrays.sort(draws);
			boolean isMatched = false;
			
			while (line != null) {
				//Convert String[] to int[]
				String[] str_nums = line.split(",");
				int[] nums = new int[str_nums.length];
				for(int i = 0 ; i < str_nums.length ; i++){
					nums[i] = Integer.parseInt(str_nums[i]);
				}
				Arrays.sort(nums);
				//System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
				isMatched = true;
				for(int k = 0 ; k < nums.length ; k++){
					if(nums[k] != draws[k]){
						isMatched = false;
					}
				}
				
				if(isMatched){
					return true;
				}
		        line = br.readLine();
		    }
			br.close();
		} catch(Exception x){
			x.printStackTrace();
		}
		return false;
	}
	
	public boolean unluckyNoExist(String filePath, int[] draws){
		try{
			//Format: must be 1 line and split by "," e.g. 1,2,3,4,5,6
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();
			//Convert String[] to int[]
			String[] str_nums = line.split(",");
			int[] nums = new int[str_nums.length];
			for(int i = 0 ; i < str_nums.length ; i++){
				nums[i] = Integer.parseInt(str_nums[i]);
			}
			for(int k = 0 ; k < nums.length ; k++){
				for(int x = 0; x < draws.length; x++){
					if(nums[k] == draws[x]){
						return true;
					}
				}
			}
			br.close();
		} catch(Exception x){
			x.printStackTrace();
		}
		return false;
	}
	
	public int countHits(int[] drawResult, int[] algoDraw){
		int hits = 0;
		for(int i = 0; i < drawResult.length; i++){
			for(int k = 0; k < algoDraw.length; k++){
				if(drawResult[i] == algoDraw[k]){
					hits++;
				}
			}
		}
		return hits;
	}
	
	public double avgHitRate(int[] hits){
		double sum = 0;
		double avg = 0;
		for(int i = 0; i < hits.length; i++){
			sum += hits[i];
		}
		
		avg = sum / hits.length;
		return avg;
	}
	
	public int maxHit(int[] hits){
		int max = 0;
		for(int i = 0; i < hits.length; i++){
			if( hits[i] > max){
				max = hits[i];
			}
		}
		return max;
	}
	
	public int countMax(int max, int[] hits){
		int count = 0;
		for(int i = 0; i < hits.length; i++){
			if(hits[i] == max)
				count++;
		}
		return count;
	}
	/*
	public int[][] setDrawsTable(String filePath){
		try{
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();
			int tableLength = 1;
			while (line != null) {
				//Convert String[] to int[]
				String[] str_nums = line.split("[ ,]");
				int[] nums = new int[str_nums.length];
				for(int i = 0 ; i < str_nums.length ; i++){
					System.out.println("str_nums[" + i + "] = " + str_nums[i] +
							" nums[" + i + "] = " + nums[i]);
					nums[i] = Integer.parseInt(str_nums[i]);
				}
				tableLength++;
			}
			
		} catch(Exception x){
			x.printStackTrace();
			return false;
		}
		return true;
	}
	
	public int[] setResultDraw(){
		
	}
	/*
	public HashMap<Integer, Integer> bingo(int[] guess, int[] result){
		if(guess.length != result.length){
			return null;
		}
		
		HashMap<Integer, Integer> compareMap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < result.length; i++){
			compareMap.put(result[i], 0);
		}
		
		for(int k = 0; k < guess.length; k++){
			if(compareMap.containsKey(guess[k])){
				compareMap.put(guess[k], compareMap.get(guess[k]) + 1);
				matched_count++;
			};
		}
		
		return compareMap;
	}*/
}
