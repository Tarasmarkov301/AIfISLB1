public class Dog {
    public static XY position=new XY();
    static char[][] SymbolOut = {
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#',}
     };
    public static void Walk(XY food, XY dog){
    position.setXY(dog.x, dog.y);
    SymbolOut[position.x][position.y]='c';
    Park.createSmellMap(food);
    int smell = 0;//сила запаха которую чучтвует србоака в своей позиции
    int count = 1000;//количество сил собаки
    XY StartPos = new XY();
        for (int i=0;i<20;i++)
            for (int j=0;j<20;j++){

                if(Park.map[i][j]==1){

                    Dog.SymbolOut[i][j]='%';
                    Park.SmellMap[i][j] = -1;

                }
            }
        boolean x = false, y=false, xx = false, yy = false;
    while(smell != 100 && count>0 ){//собака потрот одно и тоже действие пока не достигинит еди либо не закончаться сили
        StartPos.setXY(position.x, position.y);
        count--;
        //проверка каждой соседней клетки если запах там больше то она переходит в нее
        try {
        if(smell<Park.SmellMap[position.x][position.y+1]){
            position.setXY(position.x,position.y+1);
            smell=Park.SmellMap[position.x][position.y];
            SymbolOut[position.x][position.y]='*';
        }}catch (Exception e){};
        try {
        if(smell<Park.SmellMap[position.x+1][position.y]){
                if(smell == -1){
                    Park.SmellMap[position.x][position.y] = -2;
                }
                position.setXY(position.x+1,position.y);
                smell=Park.SmellMap[position.x][position.y];
                SymbolOut[position.x][position.y]='*';
            }}catch (Exception e){};
        try {
              if(smell<Park.SmellMap[position.x-1][position.y]){
                if(smell == -1){
                    Park.SmellMap[position.x][position.y] = -2;
                }
                position.setXY(position.x-1,position.y);
                smell=Park.SmellMap[position.x][position.y];
                SymbolOut[position.x][position.y]='*';
            }}catch (Exception r){};
        try {
                if(smell<Park.SmellMap[position.x][position.y-1]){
                if(smell == -1){
                    Park.SmellMap[position.x][position.y] = -2;
                }
                position.setXY(position.x,position.y-1);
                smell=Park.SmellMap[position.x][position.y];
                SymbolOut[position.x][position.y]='*';
            }}catch (Exception e){};
        if(StartPos.x == position.x && StartPos.y== position.y){
            Park.SmellMap[position.x][position.y] = 0;
            smell = -1;
        }
    }
    SymbolOut[food.x][food.y]='^';
        SymbolOut[position.x][position.y]='C';

    }
}
