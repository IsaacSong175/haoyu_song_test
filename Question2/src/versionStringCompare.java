public class versionStringCompare {
    public static int compareVersions(String str1,String str2){
        String version_pattern = "^\\d+(\\.\\d+)*";
        if(!str1.matches(version_pattern) || !str2.matches(version_pattern)){
            throw new IllegalArgumentException("Version is not in correct format!");
        }
        String[] str1_break = str1.split("\\.");
        String[] str2_break = str2.split("\\.");
        if(str1_break.length > 3 || str2_break.length > 3){
            throw new IllegalArgumentException("Version is not in correct format!");
        }
        int max_len = Math.max(str1_break.length,str2_break.length);
        for (int i = 0; i < max_len; i++) {
            int num1 = 0;
            int num2 = 0;
            if(i < str1_break.length){
                num1 = Integer.parseInt(str1_break[i]);
            }
            if(i < str2_break.length){
                num2 = Integer.parseInt(str2_break[i]);
            }
            if(num1<num2){
                return -1;
            }else if(num1>num2){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        try{
            if(compareVersions("1.0","1.1")==-1){
                System.out.println("Version 2 is newer");
            }
            if(compareVersions("1.0.1","1.1")==-1){
                System.out.println("Version 2 is newer");
            }
            if(compareVersions("1.2","1.1.1")==1){
                System.out.println("Version 1 is newer");
            }
            if(compareVersions("2.2","1.1.1")==1){
                System.out.println("Version 1 is newer");
            }
            if(compareVersions("1.1.1","1.1.1")==0){
                System.out.println("Same version");
            }
            compareVersions("1.1.1.1","1.1.1");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        try{
            compareVersions("1.-1.1","1.1.1");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        try{
            compareVersions("1.x.1","1.1.1");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
