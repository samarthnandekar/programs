package String;

/*
https://cheonhyangzhang.wordpress.com/2016/12/22/157-leetcode-java-read-n-characters-given-read4-easy/

Problem:
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:- The read function will only be called once for each test case.

Thoughts:- This is an easy question but we need to get the meaning of requirements correct.
At the beginning, I thought read4 function is reading characters from buf. So does the function read. But that’s not correct.

The meaning here is that read4() function will read 4 characters at a time from a file and then put the characters that has been read into this buf
variable.

So read() function is reading at most n characters from a file ( we don’t know what file and how it’s reading from the file), and put x characters 
into char[] buf.
 */
public class _14_Read_N_Characters_Given_Read4 extends Reader4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int offset = 0;
        char[] buf4 = new char[4];
        while(true) {
            int count = read4(buf4);
            if (count == 0) {
                break;
            }
            for (int i = 0; i < count && offset < n; i ++) {
                buf[offset] = buf4[i];
                offset ++;
            }
        }
        return offset;
    }
}

class Reader4
{
	// Dumy implementation
	int read4(char [] arr)
	{
	return 3;	
	}
}
