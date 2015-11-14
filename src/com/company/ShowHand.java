package com.company;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangsirui on 15/10/8.
 */
public class ShowHand {
    //定义该游戏最多支持多少个玩家
    private final int PLAY_NUM=5;
    //定义扑克牌的花色和数值
    private String[] types={"方片","草花","红心","黑桃"};
    private String[] values={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    //cards是一局游戏中剩下的扑克牌
    private List<String> cards=new LinkedList<String>();
    //定义所有的玩家
    private String[] players=new String[PLAY_NUM];
    //所有玩家手上的扑克牌
    private List<String>[] playersCards=new List[PLAY_NUM];
    /**
     * 初始化扑克牌，放入52张扑克牌
     * 并且使用shuffle方法将他们按随机顺序排列
     */
    public void initCards()
    {
        for (int i=0;i<types.length;i++)
        {
            for (int j=0;j<values.length;j++)
            {
                cards.add(types[i]+values[j]);
            }
        }
        Collections.shuffle(cards);//shuffle()方法可以对List中的元素进行随机排列
    }
    /**
     * 初始化玩家，为每个玩家分配用户名
     */
    public void initPlayer(String...names)//表示可以接收多个参数值，多个参数值被当做数组处理
    {
        if (names.length>PLAY_NUM||names.length<2)
        {
            //检验玩家数量，此处用异常处理更合适
            System.out.println("玩家数量不对");
            return;
        }else {
            //初始化玩家名
            for (int i=0;i<names.length;i++)
            {
                players[i]=names[i];
            }
        }
    }

    /**
     * 初始化玩家手上的扑克牌，开始游戏时每个玩家手上的扑克牌为空
     * 程序使用一个长度为0的LinkedList来表示
     */
    public void initPlayerCards()
    {
        for (int i=0;i<players.length;i++)
        {
            if (players[i]!=null && !players[i].equals(""))
            {
                playersCards[i]=new LinkedList<String>();
            }
        }
    }

    /**
     * 输出全部的扑克牌，测试用
     */
    public void showAllCards()
    {
        for (String card:cards)
        {
            System.out.print(card+" ");
        }
    }

    /**
     * 分发扑克牌
     * @param first 最先派给谁
     */
    public void deliverCard(String first)
    {
        //调用ArrayUtils工具类的search方法
        //查询出指定元素在数组中的索引
        int firstPos=search(first);
        //依次为该玩家后的每位玩家发牌
        for (int i=firstPos;i<PLAY_NUM;i++)
        {
            if (players[i]!=null)
            {
                playersCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }
        //依次为该玩家前的每位玩家发牌
        for (int i=0;i<firstPos;i++)
        {
            if (players[i]!=null)
            {
                playersCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }
    }
    //根据玩家名找到玩家的编号
    public int search(String str)
    {
        int index=0;
        for (int i=0;i<players.length;i++)
        {
            if (players[i].equals(str))
            {
                index=i;
                break;
            }
        }
        return index;
    }

    /**
     * 输出玩家手上的扑克牌
     * 实现该方法时，应该控制每个玩家看不到别人的第一张牌，但此处没有增加此功能
     */
    public void showPlayersCards()
    {
        for (int i=0;i<PLAY_NUM;i++)
        {
            //当玩家不为空时
            if (players[i]!=null)
            {
                //输出该玩家
                System.out.println(players[i]+": ");
                //遍历手上的扑克牌
                for (String card:playersCards[i])
                {
                    System.out.print(card+"\t");
                }
            }
            System.out.print("\n");
        }
    }

    /**
     *比较各个玩家的第二张牌的牌面大小
     * 取出玩家第二张牌的value进行比较，若相同，则再比较type
     */
    //取出value,存到一个String数组中
    public String[] getValue()
    {
        String[] strings=new String[PLAY_NUM];
        Matcher matcher=null;
        for (int i=0;i<playersCards.length;i++)
        {
            matcher=Pattern.compile("[^\\u4e00-\\u9fa5]").matcher(playersCards[i].get(1));
            //strings[i]=playersCards[i].get(1);//将每一位玩家的手牌取出存在String数组中
            while (matcher.find())
            {
                strings[i]=matcher.group();
                //System.out.print(strings[i]+" ");
            }
        }
        return strings;
    }
    //对第二张牌的大小进行比较
    public void compareSecondCard()
    {
        int flag=0;
        String[] strings=getValue();
//        for (String str:strings)
//        {
//            System.out.print(str+" ");
//        }
        int[] a=new int[5];
        for (int i=0;i<strings.length;i++)
        {
            a[i]=Integer.parseInt(strings[i]);
        }
        int index=0;//表示玩家编号
        int max=a[0];
        for (int i=1;i<a.length;i++)
        {
            if (max<a[i])
            {
                max=a[i];
                index=i;
            }
        }
    }

    public static void main(String[] args)
    {
        ShowHand showHand=new ShowHand();
        showHand.initPlayer("电脑玩家","本人");
        showHand.initCards();
        showHand.initPlayerCards();
        //下面测试所有扑克牌，没有实际作用
        showHand.showAllCards();
        System.out.println("----------------");
        //下面开始从本人发牌
        showHand.deliverCard("本人");
        showHand.showPlayersCards();
        /*
        这个地方需要增加处理：
        1、牌面最大的玩家下注
        2、其他玩家是否跟注
        3、游戏是否只剩一个玩家？是，则胜利
        4、如果已经是最后一张扑克牌，则需要比较剩下玩家的牌面大小
         */
        //再次从电脑玩家开始发牌
        showHand.deliverCard("电脑玩家");
        showHand.showPlayersCards();
        //判断第二张牌的大小
        showHand.compareSecondCard();
    }
}
