class Day153 {
    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        String[] stack = new String[folders.length];
        int top = -1;
        for (int i = 0; i < folders.length; i++) {
            String currentFolder = folders[i];
            if (currentFolder.equals("") || currentFolder.equals("."))
                continue;
            else if (currentFolder.equals("..")) {
                if (top != -1) top--;
            }
            else {
                top++;
                stack[top] = currentFolder;
            }
        }
        if (top == -1) return "/";
        String answer = "";
        for (int i = 0; i <= top; i++)
            answer = answer + "/" + stack[i];
        return answer;
    }
}