package myCharStream.demo05;

/**
 * @author ����
 * @date 2021��07��05�� 18:17
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
    ����
        ����һ���ļ�����洢�˰༶ͬѧ��������ÿһ������ռһ�У�Ҫ��ͨ������ʵ���������

    ˼·��
        1:�����ַ���������������
        2:����ArrayList���϶���
        3:�����ַ���������������ķ���������
        4:�Ѷ�ȡ�����ַ������ݴ洢��������
        5:�ͷ���Դ
        6:ʹ��Random����һ���������������ķ�Χ�ڣ�[0,���ϵĳ���)
        7:�ѵ�6���������������Ϊ������ArrayList�����л�ȡֵ
        8:�ѵ�7���õ�����������ڿ���̨
 */
public class CallNameDemo {
    public static void main(String[] args) throws IOException {
        //�����ַ��������������󡪡���
        BufferedReader br = new BufferedReader(new FileReader("D:\\02-looking for job\\00-Project\\43-LearnJavaSE\\LearnJavaSE\\03-���������JavaSE\\02-�ڶ��׶δ�������\\day09-code\\content\\a.txt"));
        //����ArrayList���϶���
        ArrayList<String> array = new ArrayList<>();
        //�����ַ���������������ķ���������
        String line;
        while((line = br.readLine()) != null){
            //�Ѷ�ȡ�����ַ������ݴ洢��������
            array.add(line);
        }

        //�ͷ���Դ
        br.close();

        //ʹ��Random����һ���������������ķ�Χ�ڣ�[0,���ϵĳ���)
        Random r = new Random();
        int index = r.nextInt(array.size());

        //�ѵ�6���������������Ϊ������ArrayList�����л�ȡֵ
        String name = array.get(index);


        //�ѵ�7���õ�����������ڿ���̨
        System.out.println("�������ǣ�" + name);
    }
}
