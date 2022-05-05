 public class Park {
    public static int[][] map = {
            {0,0,2,2,2,2,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
            {0,0,2,2,2,0,0,0,0,2,0,0,0,0,1,1,1,1,0,0},
            {0,0,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0},
            {0,0,2,2,2,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,0,0,0,0,0},
            {0,0,0,0,0,2,2,2,0,0,0,0,2,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {2,2,2,2,2,2,2,2,2,2,0,1,0,0,2,2,0,2,2,2},
            {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,2,0,0,2,2,2,0,0,0,0,0,2,0,2,0},
            {0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,2,0,0,0,0,0,2,2,0,0,0,2,0,0,2,0},
            {0,0,0,0,0,0,0,0,0,0,2,2,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2},
            {0,0,0,0,0,0,0,1,2,0,0,0,2,0,0,0,1,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,2,0,0,1,1,0,0,0},
            {0,0,0,0,2,2,2,0,0,0,0,0,2,0,0,0,0,0,0,0}
    };
    public static int[][] SmellMap={
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    public static void createSmellMap(XY h){
        SmellMap[h.x][h.y] = 100;
        for(int k=0;k<100;k++)
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                try{
                if(SmellMap[i][j]<SmellMap[i][j+1]){
                    if(map[i][j]==0)
                    SmellMap[i][j]=SmellMap[i][j+1]-1;
                }}catch (Exception e){};
                try {
                if(SmellMap[i][j]<SmellMap[i+1][j]){
                    if(map[i][j]==0)
                        SmellMap[i][j]=SmellMap[i+1][j]-1;

                }}catch (Exception e){};
                try {
                if(SmellMap[i][j]<SmellMap[i-1][j]){
                    if(map[i][j]==0)
                        SmellMap[i][j]=SmellMap[i-1][j]-1;
                }}catch (Exception r){};
                try {
                if(SmellMap[i][j]<SmellMap[i][j-1]){
                    if(map[i][j]==0)
                        SmellMap[i][j]=SmellMap[i][j-1]-1;
                }}catch (Exception e){};
            }
        }
        for (int i=0;i<20;i++)
            for (int j=0;j<20;j++){
                if(map[i][j]==2){
                    Dog.SymbolOut[i][j]='@';
                    SmellMap[i][j] = -1;

                }
                if(map[i][j]==1){

                    Dog.SymbolOut[i][j]='%';
                    SmellMap[i][j] = -1;

                }
            }


    }
    public static void reload(){
        int[][] RelMap = {
                {0,0,2,2,2,2,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
                {0,0,2,2,2,0,0,0,0,2,0,0,0,0,1,1,1,1,0,0},
                {0,0,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0},
                {0,0,2,2,2,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,0,0,0,0,0},
                {0,0,0,0,0,2,2,2,0,0,0,0,2,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,2,2,2,2,2,2,0,1,0,0,2,2,0,2,2,2},
                {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,2,0,0,2,2,2,0,0,0,0,0,2,0,2,0},
                {0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,2,0,0,0,0,0,2,2,0,0,0,2,0,0,2,0},
                {0,0,0,0,0,0,0,0,0,0,2,2,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,2,2,2,2,2,0,0,0,2,2,2,2,2,2,2,2},
                {0,0,0,0,0,0,0,1,2,0,0,0,2,0,0,0,1,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,2,0,0,1,1,0,0,0},
                {0,0,0,0,2,2,2,0,0,0,0,0,2,0,0,0,0,0,0,0}
        };
      for(int i=0;i<20;i++)
          for(int j=0;j<20;j++){
              SmellMap[i][j]=0;
          }
        for(int i=0;i<20;i++)
        for(int j=0;j<20;j++){
            map[i][j]=RelMap[i][j];
        }
        for(int i=0;i<20;i++)
            for(int j=0;j<20;j++){
                Dog.SymbolOut[i][j]='#';
            }
        for (int i=0;i<20;i++)
            for (int j=0;j<20;j++){
                if(map[i][j]==2){
                    Dog.SymbolOut[i][j]='@';
                    SmellMap[i][j] = -1;

                }
                if(map[i][j]==1){

                    Dog.SymbolOut[i][j]='%';
                    SmellMap[i][j] = -1;

                }
            }
    }
    public static void main(String[] args){
        XY food = new XY();
        food.setXY(3,15);
        createSmellMap(food);

    for(int i=0;i<20;i++){
         for(int j=0;j<20;j++){
             System.out.print(SmellMap[i][j]+" ");

         }System.out.println();
    }
     }
}