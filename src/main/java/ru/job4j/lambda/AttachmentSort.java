package ru.job4j.lambda;

import java.util.*;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13));

        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator<Attachment> comparator1 = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                int result = 0;
                int length = Math.min(o1.getName().length(), o2.getName().length());
                for (int i = 0; i < length; i++) {
                    result = Character.compare(o1.getName().charAt(i), o2.getName().charAt(i));
                }
                return result;
            }
        };
        attachments.sort(comparator1);
        System.out.println(attachments);
    }
}
