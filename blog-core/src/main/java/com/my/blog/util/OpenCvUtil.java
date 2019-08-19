package com.my.blog.util;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Service
public class OpenCvUtil {


//    private List<Face> faceEntities;
//    private Mat image;
//
//    public OpenCvUtil detectFace(String imgStr) throws IOException {
//        faceEntities = new ArrayList<>();
//        String faceLib = "D:/blog/src/main/resources/haarcascades/haarcascade_frontalface_alt.xml";
//        String eyeLib = "D:/blog/src/main/resources/haarcascades/haarcascade_eye.xml";
//
//        MatOfRect faceDetections = new MatOfRect();
//
//        CascadeClassifier faceDetector = new CascadeClassifier(faceLib);
//        image = Imgcodecs.imdecode(new MatOfByte(Base64.getDecoder().decode(imgStr)), Imgcodecs.IMREAD_UNCHANGED);
//
//        faceDetector.detectMultiScale(image, faceDetections);
//
//        System.out.println(String.format("发现 %s 张脸", faceDetections.toArray().length));
//
//        for (Rect rect : faceDetections.toArray()) {
//            faceEntities.add(new Face(rect.x, rect.y, rect.width, rect.height, 0));
//        }
//
//        return this;
//    }
//
//    public static Mat FeatureOrbLannbased(String srcStr, String dstStr) {
//        OpenCV.loadLocally();
//
//        Mat big_src = Imgcodecs.imdecode(new MatOfByte(Base64.getDecoder().decode(srcStr)), Imgcodecs.IMREAD_UNCHANGED);
//        Mat big_dst = Imgcodecs.imdecode(new MatOfByte(Base64.getDecoder().decode(dstStr)), Imgcodecs.IMREAD_UNCHANGED);
//
//        MatOfRect mr_src = OpenCvUtil.getFace(big_src);
//        Mat src = big_src.submat(mr_src.toArray()[0]);
//
//        MatOfRect mr_dst = OpenCvUtil.getFace(big_dst);
//        Mat dst = big_dst.submat(mr_dst.toArray()[0]);
//
//
//        Mat gray_src = new Mat();
//        Mat gray_dst = new Mat();
//
//        // 转换为灰度
//        Imgproc.cvtColor(src, gray_src, Imgproc.COLOR_RGB2GRAY);
//        Imgproc.cvtColor(dst, gray_dst, Imgproc.COLOR_RGB2GRAY);
//
//        // 初始化ORB检测描述子
//        //特别提示下这里opencv暂时不支持SIFT、SURF检测方法，这个好像是opencv(windows) java版的一个bug
//        FeatureDetector fd = FeatureDetector.create(FeatureDetector.ORB);
//        DescriptorExtractor de = DescriptorExtractor.create(DescriptorExtractor.ORB);
//        DescriptorMatcher Matcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE_L1);
//
//        // 关键点及特征描述矩阵声明
//        MatOfKeyPoint mkp = new MatOfKeyPoint(), mkp2 = new MatOfKeyPoint();
//        Mat desc = new Mat(), desc2 = new Mat();
//        // 计算ORB特征关键点
//        fd.detect(gray_src, mkp);
//        fd.detect(gray_dst, mkp2);
//        // 计算ORB特征描述矩阵
//        de.compute(gray_src, mkp, desc);
//        de.compute(gray_dst, mkp2, desc2);
//
//
//        MatOfDMatch Matches = new MatOfDMatch();
//        Matcher.match(desc, desc2, Matches);
//
//        double maxDist = Double.MIN_VALUE;
//        double minDist = Double.MAX_VALUE;
//
//        DMatch[] mats = Matches.toArray();
//        for (int i = 0; i < mats.length; i++) {
//            double dist = mats[i].distance;
//            if (dist < minDist) {
//                minDist = dist;
//            }
//            if (dist > maxDist) {
//                maxDist = dist;
//            }
//        }
//        System.out.println("Min Distance:" + minDist);
//        System.out.println("Max Distance:" + maxDist);
//        List<DMatch> goodMatch = new LinkedList<>();
//
//
//        for (int i = 0; i < mats.length; i++) {
//            double dist = mats[i].distance;
//            if (dist <= 2 * minDist) {
//                goodMatch.add(mats[i]);
//            }
//        }
//
//        log.info("mats" + mats.length);
//        log.info("goodMatch" + goodMatch.size());
//        Matches.fromList(goodMatch);
//        // Show result
//        Mat OutImage = new Mat();
//        Features2d.drawMatches(gray_src, mkp, gray_dst, mkp2, Matches, OutImage);
//        Imgcodecs.imwrite("d:/Y4.jpg", OutImage);
//        return OutImage;
//    }
//
//
//    public List<Face> toList() {
//        return faceEntities;
//    }
//
//
//    public byte[] toImage() {
//        for (Face fc : faceEntities) {
//            Imgproc.rectangle(image, new Point(fc.getX(), fc.getY()), new Point(fc.getX() + fc.getWidth(), fc.getY() + fc.getHeight()), new Scalar(0, 255, 0));
//        }
//        return mat2Image(image);
//    }
//
//    private byte[] mat2Image(Mat frame) {
//        MatOfByte buffer = new MatOfByte();
//        Imgcodecs.imencode(".jpg", frame, buffer);
//        return buffer.toArray();
//    }
//
//    public static MatOfRect getFace(Mat src) {
//        Mat result = src.clone();
//        if (src.cols() > 1000 || src.rows() > 1000) {
//            Imgproc.resize(src, result, new Size(src.cols() / 3, src.rows() / 3));
//        }
//
//        CascadeClassifier faceDetector = new CascadeClassifier("D:/blog/src/main/resources/haarcascades/haarcascade_frontalface_alt2.xml");
//        MatOfRect objDetections = new MatOfRect();
//        faceDetector.detectMultiScale(result, objDetections);
//
//        return objDetections;
//    }
}
