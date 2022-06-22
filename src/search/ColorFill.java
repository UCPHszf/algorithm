package search;

public class ColorFill {

    boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        visited = new boolean[image.length][image[0].length];
        int originalColor = image[sr][sc];
        dfs(image, sr, sc, originalColor, newColor);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int originalColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc] || image[sr][sc] != originalColor)
            return;
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, originalColor, newColor);
        dfs(image, sr + 1, sc, originalColor, newColor);
        dfs(image, sr, sc - 1, originalColor, newColor);
        dfs(image, sr, sc + 1, originalColor, newColor);
    }
}
