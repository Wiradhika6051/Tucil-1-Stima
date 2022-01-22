class Color{
    public static String getColor(int idx){
        String color="";
        if(idx==-1){//default
            color = "\u001b[0m";//reset
        }
        else {
            switch (idx % 6) {
                case 0:
                    color = "\u001b[31m";//red
                    break;
                case 1:
                    color = "\u001b[32m";//green
                    break;
                case 2:
                    color = "\u001b[33m";//yellow
                    break;
                case 3:
                    color = "\u001b[34m";//blue
                    break;
                case 4:
                    color = "\u001b[35m";//magenta
                    break;
                case 5:
                    color = "\u001b[36m";//cyan
                    break;
            }
        }
        return color;
    }
}