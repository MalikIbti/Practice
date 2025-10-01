//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

package seachingAndSorting;

public class KthSmallestElementinaSortedMatrix_378 {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int low = matrix[0][0];
            int high = matrix[n-1][n-1];
            while(low<high){
                int mid = low+(high-low)/2;
                int count = countLessEqual(matrix, mid);
                if(count<k){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
            return low;
        }

        public int countLessEqual(int[][]matrix, int mid){
            int n = matrix.length;
            int row = n-1;
            int column = 0;
            int count = 0;

            while(row>=0 && column<n){
                if(matrix[row][column]<=mid){
                    count += row+1;
                    column++;
                }else{
                    row--;
                }
            }
            return count;
        }
    }
