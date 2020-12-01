var moveZeroes = function (nums) {
  let len = nums.length;
  let pos = 0;
  for (let i = 0; i < len; i++) {
    if (nums[pos] === 0) {
      nums.splice(pos, 1);
      nums.push(0);
      continue;
    }
    pos++;
  }
  return nums;
};
