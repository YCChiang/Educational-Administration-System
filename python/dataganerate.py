import pandas as pd
import random
specialtypath = "specialty.xlsx"

def studentInfo(path, file):
    data = pd.read_excel(path + '\\' + file)
    specialty = pd.read_excel(specialtypath, sheet_name='specialty')
    user = pd.DataFrame(columns=['name','password','type'])
    specialtyNum = len(specialty)
    data[['department', 'id', 'specialty', 'class']] = data[['department', 'id', 'specialty', 'class']].astype('str')
    for index, row in data.iterrows():
        num = random.randint(0, specialtyNum-1)
        data.at[index, 'department'] = specialty.at[num, '院系']
        data.at[index, 'specialty'] = specialty.at[num, '专业']
        year = random.randint(2000, 2020)
        data.at[index, 'admission_time'] = year
        data.at[index, 'age'] = random.randint(16, 24)
        data.at[index, 'class'] = '{:0>2d}'.format(year%100) +'-'+ str(random.randint(1,3))
        id = str(year) + '{:0>6d}'.format(index)
        data.at[index, 'id'] = id
        user = user.append({'name':id, 'password':id, 'type':'学生'}, ignore_index=True)
    data.to_csv(path+'\\'+"student.csv", index=False, encoding='utf-8')
    user.to_csv(path+'\\'+"student_user.csv", index=False, encoding='utf-8')


def TeacherInfo(path, file):
    title = ['讲师','讲师','讲师','讲师','讲师','讲师','讲师','副教授','副教授','副教授','副教授','教授']
    data = pd.read_excel(path + '\\' + file)
    specialty = pd.read_excel(specialtypath, sheet_name='specialty')
    departments = specialty['院系'].tolist()
    departments.append('马克思主义学院')
    user = pd.DataFrame(columns=['name','password','type'])
    data[['department', 'id', 'title']] = data[['department', 'id', 'title']].astype('str')
    for index, row in data.iterrows():
        data.at[index, 'department'] = departments[random.randint(0, len(specialty)-1)]
        data.at[index, 'title'] = random.choice(title)
        id = '{:0>4d}'.format(index)
        data.at[index, 'id'] = id
        user = user.append({'name':id, 'password':id, 'type':'教师'}, ignore_index=True)
    data.to_csv(path+'\\'+"teacher.csv", index=False, encoding='utf-8')
    user.to_csv(path+'\\'+"teacher_user.csv", index=False, encoding='utf-8')

def classInfo(path):
    departments = ['马克思主义学院','理学院','信息科学与工程学院','石油工程学院','外国语学院']
    times = ['8:00:00', '10:05:00', '13:30:00', '15:30:00','18:30:00']
    teacher = pd.read_csv("teacher.csv")
    className = pd.read_excel("class.xlsx")
    classinfo = pd.DataFrame(columns=['id','name', 'hour', 'capacity','year','start_week','end_week','teacher_id','teacher_name','credit'])
    classTime = pd.DataFrame(columns=['class_id','day','time','classroom'])
    for i in range(0, len(departments)-1):
        temp = teacher[teacher['department'] == departments[i]]
        names = className[departments[i]]
        for index, row in temp.iterrows():
            teacher_id = row['id']
            teacher_name = row['name']
            for j in range(0, random.randint(1, 10)):
                year = random.randint(2015, 2020)
                id = str(year) + '{:0>6d}'.format(index)
                name = names[random.randint(0, len(names)-1)]
                credit = random.randint(1, 2)*2
                start_week = 1
                end_week = 14
                year = str(year) + random.choice(['春','秋'])
                if(credit == 2):
                    start_week == random.choice([1, 8])
                    end_week = start_week+7
                classinfo = classinfo.append({'id':id, 'name':name, 'hour':credit*12, 'teacher_id':teacher_id,'teacher_name':teacher_name,'capacity':random.choice([30, 50, 100, 120]),'start_week':start_week,'end_week':end_week,'year':year,'credit':credit}, ignore_index=True)
                day1 = random.randint(1,5)
                day2 = random.randint(1,5)
                while(day1 == day2):
                    day2 = random.randint(1,5)
                classroom = '三教' + str(random.randint(1,5)*100+random.randint(1,13))
                classTime = classTime.append({'class_id':id,'day':day1,'time':random.choice(times),'classroom':classroom}, ignore_index=True)
                classroom = '三教' + str(random.randint(1,5)*100+random.randint(1,13))
                classTime = classTime.append({'class_id':id,'day':day1,'time':random.choice(times),'classroom':classroom}, ignore_index=True)
    classinfo.to_csv(path+"\\"+"classInfo.csv", index=False)
    classTime.to_csv(path+"\\"+"classTime.csv", index=False)


classInfo(r"C:\Users\chien\Desktop\New folder\python")