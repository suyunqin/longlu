-- 字典类型  ： 请假条状态
SELECT * FROM sys_dict 
INSERT INTO sys_dict(sid,NAME,typeid)VALUES(1,'待审核',1);
INSERT INTO sys_dict(sid,NAME,typeid)VALUES(2,'通过',1);
INSERT INTO sys_dict(sid,NAME,typeid)VALUES(3,'打回',1);
INSERT INTO sys_dict(sid,NAME,typeid)VALUES(4,'拒绝',1);