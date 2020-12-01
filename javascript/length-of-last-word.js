/**
 * @param {string} s
 * @return {number}
 * https://leetcode.com/problems/length-of-last-word/
 */
var lengthOfLastWord = function (s) {
  if (s === null) {
    return 0;
  }

  s = s.trim();
  const len = s.length;
  let cnt = 0;
  for (let i = len - 1; i > 0; i--) {
    const c = s.charAt(i);
    if (checkCase(c)) {
      cnt++;
    } else {
      return cnt;
    }
  }
  return 0;
};
function checkCase(ch) {
  if (!isNaN(ch * 1)) {
    return false;
  } else {
    if (ch == ch.toUpperCase()) {
      return true;
    }
    if (ch == ch.toLowerCase()) {
      return true;
    }
  }
}
