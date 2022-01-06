package file;

import model.Account;

import java.io.*;
//
//public class IOFile <E> {
//    public static void ghiFileAcc(File file) throws IOException {
//        BufferedWriter bufferedWriter = null;
//        try {
//            //FileWriter fileWriter = new FileWriter(file, false);
//            OutputStream outputStream = new FileOutputStream(file2);
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
//
//            //bufferedWriter = new BufferedWriter(fileWriter);
//
//            for (Account pp : list1) {
//                outputStreamWriter.write(pp.ghi1());
//                outputStreamWriter.newLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            //assert bufferedWriter != null;
//            //bufferedWriter.close();
//            OutputStream.close();
//        }
//    }
//        FileOutputStream fileOutputStream = null;
//
//        try {
//
//            fileOutputStream = new FileOutputStream(file2);
//            for (Account pp : list1) {
//                fileOutputStream.write(pp.ghi1());
//                //outputStreamWriter.newLine();
//            }
//            fileOutputStream.flush();
//            fileOutputStream.close();
//            System.out.println("File written successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (fileOutputStream != null) {
//                    fileOutputStream.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//    }
//}
