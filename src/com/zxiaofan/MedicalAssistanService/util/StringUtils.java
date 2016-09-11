package com.zxiaofan.MedicalAssistanService.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.zxiaofan.MedicalAssistanService.constant.Constant;
import com.zxiaofan.MedicalAssistanService.constant.ConstantApi;

public final class StringUtils {
    /**
     * 构造函数.
     * 
     */
    private StringUtils() {
        throw new RuntimeException("this is a util class,can not instance");
    }

    /**
     * 去空格去换行.
     *
     * @param str
     *            str
     * @return str
     */
    public static String formatStr(String str) {
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            str = m.replaceAll("");
        }
        return str;
    }

    /**
     * 读取本地文件返回String.
     * 
     * @param path
     */
    private static String readFile(String path) {
        StringBuffer buffer = new StringBuffer();
        try {
            File file = new File(path);
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), Constant.ENCODE);
            BufferedReader ins = new BufferedReader(read);
            String dataLine = "";
            while (null != (dataLine = ins.readLine())) {
                buffer.append(dataLine).append("\r\n");
            }
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * Unicode转换.
     * 
     * @param ori
     * @return
     */
    public static String convertUnicode(String ori) {
        char aChar;
        int len = ori.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = ori.charAt(x++);
            if (aChar == '\\') {
                aChar = ori.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = ori.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);

        }
        return outBuffer.toString();
    }

    /**
     * 读取症状字段，匹配对应关系.
     * 
     * @param bool
     *            bool为false返回<A,PainPerception>,为true时返回<PainPerception,A>
     * @param encode
     *            编码
     */

    /**
     * 读取本地配置文件并生成Map.
     * 
     * @param path
     *            文件路径
     * @param x
     *            key对应取数组第几个元素
     * @param y
     *            value对应取数组第几个元素
     * @param bool
     *            为false是x、y反转
     * @return
     */
    public static Map<String, String> initNameCharMap(String path, int x, int y, boolean bool) {
        Map<String, String> nameCharMap = new HashMap<>();
        try {
            File file = new File(getAbsolutePath(path));
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), Constant.ENCODE);
            BufferedReader ins = new BufferedReader(read);
            String dataLine = "";
            String[] descField = {};
            while (null != (dataLine = ins.readLine())) {
                if (!"".equals(dataLine)) {
                    descField = dataLine.split("=");
                    if (descField.length > Math.max(x, y)) {
                        if (bool) {
                            nameCharMap.put(descField[x], descField[y]);
                        } else {
                            nameCharMap.put(descField[y], descField[x]);
                        }
                    }
                }
            }
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nameCharMap;
    }

    /**
     * 检查参数是否合法.
     * 
     * @param param
     *            待匹配参数
     * @param 正则
     * @return 结果
     */
    public static boolean legal(String param, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(param);
        while (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 用户名、密码是否合法.
     * 
     * @param name
     *            用户名
     * @param pwd
     *            密码
     * @return 合法与否
     */
    public static boolean isLegal(String name, String pwd) {
        if (StringUtils.legal(name, ConstantApi.Reg_Char_Num_Punctuation) && StringUtils.legal(pwd, ConstantApi.Reg_Char_Pwd)) {
            return true;
        }
        return false;
    }

    /**
     * 初始化Map(症状-key).
     * 
     */
    public static void initFeatureKeyMap() {
        if (!ConstantApi.featureKeyMap.isEmpty()) {
            return;
        }
        try {
            String configPath = getAbsolutePath(Constant.path_Symptom_Key);
            File file = new File(configPath);
            String featureKey = FileUtils.readFileToString(file, Constant.ENCODE);
            ConstantApi.featureKeyMap = new Gson().fromJson(featureKey, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            Logging.log.error(e.getMessage());
        }
    }

    /**
     * 通过相对路径获取绝对路径.
     * 
     * @param path
     *            相对路径(com/..)
     * @return 绝对路径
     * @throws Exception
     *             e
     */
    public static String getAbsolutePath(String path) throws Exception {
        URL url = StringUtils.class.getClassLoader().getResource(path);
        return java.net.URLDecoder.decode(url.getFile(), "utf-8");
    }
}
