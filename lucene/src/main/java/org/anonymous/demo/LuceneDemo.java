package org.anonymous.demo;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author child
 * 2019/6/2 22:23
 */
public class LuceneDemo {

    public void createIndex() {
        //创建一个 directory 对象,指定索引库保存的位置
        //把索引库保存在内存中
//        FSDirectory.open(Path.of(""));
    }

    //Paths.get(string)
    @Test
    public void test() throws IOException {
        //以当前项目为根目录
        Path path = Paths.get("./src\\main\\java\\org\\anonymous\\demo\\LuceneDemo.java");
//        System.out.println(path);
        String s = FileUtils.readFileToString(path.toFile(), "utf-8");
        System.out.println(s);
    }

    @Test
    public void test1() throws IOException {
        Path path = Path.of("src\\main\\java\\org\\anonymous\\demo\\LuceneDemo.java");
        String s = FileUtils.readFileToString(path.toFile(), "utf-8");
        System.out.println(s);
    }
}
