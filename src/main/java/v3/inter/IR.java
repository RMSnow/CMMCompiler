package v3.inter;

import v3.Conf;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 更低层的中间代码（四元式表示）
 */
public class IR {
    Scanner scanner = new Scanner(Conf.interFile);

    public IR() throws FileNotFoundException {
    }
}
