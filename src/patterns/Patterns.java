package src.patterns;

public class Patterns {
    // method to print stars in square pattern
    public void printSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // method to print right angled triangle with *
    public void printTriangleWithStar(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // method to print numbers in right angled triangle with j
    public void printTriangleWithNumber1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // method to print numbers in right angled triangle with i
    public void printTriangleWithNumber2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // method to print inverse triangle
    public void printInverseTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < (n - i + 1); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // method to print inverse triangle with number
    public void printInverseTriangleNumber(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i + 1); j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // method to print pyramid
    public void printPyramid(int n) {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // method to print inverse pyramid
    public void printInversePyramid(int n) {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // method to print diamond
    public void printDiamond(int n) {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // star
            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");
            }

            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // method to print merge triangle
    public void printMergeTriangle(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;
            if (i > n)
                stars = 2 * n - i;
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // method to print ones and zeros in triangle
    public void printOnesZersTriangle(int n) {
        int start = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                start = 1;
            } else {
                start = 0;
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(start + " ");
                start = 1 - start;
            }
            System.out.println();
        }
    }

    // method to print adjacent number pyramid
    public void adjacentNumberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // number
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }

            // space
            for (int j = 1; j <= 2 * n - 2 * i; j++) {
                System.out.print("  ");
            }

            // number
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // method to print triangle with incremented number
    public void printTriangleWithIncrementedNumber(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    // method to print alphabets in triangular form, wrt j
    public void printAlphabetTriagulary(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) ('A' + j) + " ");
            }
            System.out.println();
        }
    }

    // method to print the inverse alphabets triangle, wrt j
    public void printInverseAplhabetTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print((char) ('A' + j) + " ");
            }
            System.out.println();
        }
    }

    // method to print alphabet pyramid
    public void printAplhabetPyramid(int n) {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < n - (i + 1); j++) {
                System.out.print("  ");
            }

            // alpha
            char ch = 'A';
            int ta = 2 * i + 1;
            for (int j = 0; j < ta; j++) {
                if (j < ta / 2)
                    System.out.print(ch++ + " ");
                else
                    System.out.print(ch-- + " ");
            }

            // space
            for (int j = 0; j < n - (i + 1); j++) {
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    // method to print alphabet in reverse order wrt total input
    public void printAlphabetReverse(int n) {
        for (int i = 0; i < n; i++) {
            char ch = 'A';
            for (int j = n - i - 1; j < n; j++) {
                System.out.print((char) (ch + j) + " ");
            }
            System.out.println();
        }
    }

    // method to print hollow pyramid
    public void hollowPyramid(int n) {
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }

            // spaces
            for (int j = 0; j < 2 * i; j++) {
                System.out.print("  ");
            }

            // starts
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            // spaces
            for (int j = 2 * n - 2 * (i + 1); j > 0; j--) {
                System.out.print("  ");
            }

            // starts
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // method to print inverse hollow pyramid
    public void inverseHollowPyramid(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            // stars
            int stars = i;
            if (i > n)
                stars = 2 * n - i;
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }

            // space
            int space = 2 * n - 2 * i;
            if (i > n)
                space = 2 * i - 2 * n;
            for (int j = 1; j <= space; j++) {
                System.out.print("  ");
            }

            // stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    // method to print hollow square
    public void hollowSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // method to print circular numbers
    public void circularNumber(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                int top = i;
                int left = j;
                int right = (2 * n - 2) - j;
                int bottom = (2 * n - 2) - i;
                System.out.print(n - Math.min(Math.min(top, bottom), Math.min(left, right)) + " ");
            }
            System.out.println();
        }
    }
}
