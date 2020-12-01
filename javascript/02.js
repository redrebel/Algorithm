/**
 * @param {string} A
 * @param {string} B
 * @return {boolean}
 * avvvvb = bvvva
 * https://leetcode.com/problems/buddy-strings/
 */

var buddyStrings = function (A, B) {
  // 길이가 같은지
  if (A.length !== B.length) {
    return false;
  }

  if (A === B) {
    const m = new Map();
    for (var i = 0; i < A.length; i++) {
      if (m.has(A[i])) {
        return true;
      }
      m.set(A[i]);
    }
    return false;
  }

  let a1;
  let a2;
  let b1;
  let b2;
  let diffCnt = 0;
  for (let i = 0; i < A.length; i++) {
    if (A[i] !== B[i]) {
      diffCnt++;
      if (diffCnt > 2) {
        return false;
      }
      if (diffCnt === 1) {
        a1 = A[i];
        b1 = B[i];
      }
      if (diffCnt === 2) {
        a2 = A[i];
        b2 = B[i];
      }
    }
  }

  if (diffCnt === 2 && a1 === b2 && a2 === b1) {
    return true;
  }

  return false;
};
