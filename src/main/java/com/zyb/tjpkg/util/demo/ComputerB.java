package com.zyb.tjpkg.util.demo;

/**
 * Created by Yambo Zhang on 2020-06-29.
 */
public class ComputerB {

    private String mainBoard ;     // 主板
    private String cpu ;           // cpu
    private String hd ;            // 硬盘
    private String powerSupplier ; // 电源
    private String graphicsCard;   // 显卡

    // 其它一些可选配置
    private String mouse ; // 鼠标
    private String computerCase ; //机箱
    private String mousePad ;   //鼠标垫
    private String other ;  //其它配件

    // ComputerB 自己充当 Director
    private ComputerB(ComputerBuilder builder) {
        this.mainBoard = builder.mainBoard ;
        this.cpu = builder.cpu ;
        this.hd = builder.hd ;
        this.powerSupplier = builder.powerSupplier ;
        this.graphicsCard = builder.graphicsCard ;

        this.mouse = builder.mouse ;
        this.computerCase = builder.computerCase ;
        this.mousePad = builder.mousePad ;
        this.other = builder.other ;
    }
    // 声明一个静态内存类 Builder
    public static class ComputerBuilder{
        // 一个电脑的必须配置
        private String mainBoard ;     // 主板
        private String cpu ;           // cpu
        private String hd ;            // 硬盘
        private String powerSupplier ; // 电源
        private String graphicsCard;   // 显卡

        // 其它一些可选配置
        private String mouse ; // 鼠标
        private String computerCase ; //机箱
        private String mousePad ;   //鼠标垫
        private String other ;  //其它配件

        // 这里声明一些必须要传的参数「规定这些参数是必须传的，这里只是举例，再实中可能参数都是可选的」
        public ComputerBuilder(String mainBoard,String cpu,String hd,String powerSupplier,String graphicsCard){
            this.mainBoard = mainBoard ;
            this.cpu = cpu ;
            this.hd = hd ;
            this.powerSupplier = powerSupplier ;
            this.graphicsCard = graphicsCard ;
        }

        public ComputerBuilder setMainBoard(String mainBoard) {
            this.mainBoard = mainBoard;
            return this ;
        }

        public ComputerBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this ;
        }


        // 生成最终的产品
        public ComputerB build(){
            return new ComputerB(this) ;
        }
    }


    public static void main(String[] args) {
        ComputerB computerB = new ComputerB.ComputerBuilder("主板","cpu","hd","电源","显卡").setCpu("cpu2").build();
        computerB = new ComputerB.ComputerBuilder("主板","cpu","hd","电源","显卡").build();
        System.out.println();
    }
}