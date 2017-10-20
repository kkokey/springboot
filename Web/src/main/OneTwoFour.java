class OneTwoFour {
    private static final int dividNum = 3;

    public String change124(int n) {

        String answer = "";
        String fstNum = "";
        String secNum = "";

        int quot = (int)Math.ceil((double)n / (double)dividNum);	// 자리수가 증가되어야 하는 횟수.
        System.out.println(addDigitCount(n, answer));

//     if(quot < 2){		// 2이하의 수는 1,2,4 이므로 자릿수 증가 없음.
//       secNum = getChangeNum(n%dividNum);
//     }else{		// 2 이상의 숫자는 자릿수가 증가되어야 함.
//       System.out.println(addDigitCount(quot));
//       secNum = getChangeNum(n%dividNum);
//     }
//     //System.out.println();
//     answer = n + "|" + fstNum+secNum;

        return answer;
    }
    public String addDigitCount(int dcNum, String rs){
        int[] otf = new int[]{1,2,4};
        int ni = 0;
        for(int i=0; i<dcNum; i++){
            // System.out.println(i+"|"+otf[ni]);

            rs = addNum(rs);
            System.out.println(rs);
            ni++;
            if(ni == 3){
                ni = 0;
            }
        }
        return "";
    }

    public String addNum(String rs){
        int pin = rs.length();
        if(rs.length() > 0){
            while(pin <= rs.length()){
                System.out.println(rs.substring(pin-1, pin));
                if("1".equals(getChangeNum(rs.substring(pin-1, pin)))){
                    rs = rs.substring(0, pin-1) + getChangeNum(rs.substring(pin-1, pin)) + rs.substring(pin, rs.length());
                    if(rs.length() == 1){
                        rs = rs + "1";
                    }
                    pin--;
                    System.out.println("pin:"+pin);
                    if(pin > 0){
                        continue;
                    }
                    break;
                }else{
                    rs = rs.substring(0, pin-1) + getChangeNum(rs.substring(pin-1, pin)) + rs.substring(pin, rs.length());
                    break;
                }
            }
        }else{
            rs = "1";
        }
        return rs;
    }

    public String getChangeNum(String str){
        if(str.equals("1")){
            str = "2";
        }else if(str.equals("2")){
            str = "4";
        }else if(str.equals("4")){
            str = "1";
        }
        return str;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        OneTwoFour oneTwoFour = new OneTwoFour();
    /*
    System.out.println(oneTwoFour.change124(1));
    System.out.println(oneTwoFour.change124(2));
		System.out.println(oneTwoFour.change124(3));
    System.out.println(oneTwoFour.change124(4));
    System.out.println(oneTwoFour.change124(5));
    System.out.println(oneTwoFour.change124(6));
    System.out.println(oneTwoFour.change124(7));
    System.out.println(oneTwoFour.change124(8));
    System.out.println(oneTwoFour.change124(9));
    */
        System.out.println(oneTwoFour.change124(13));
        System.out.println("==");
    /*
    System.out.println(oneTwoFour.change124(12));
    System.out.println(oneTwoFour.change124(12));
    System.out.println(oneTwoFour.change124(13));
    System.out.println(oneTwoFour.change124(14));
    System.out.println(oneTwoFour.change124(41));
    */
    }
}
