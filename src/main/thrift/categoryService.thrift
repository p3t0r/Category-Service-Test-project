namespace java com.log4p.services

struct Category {
  1: i64 id
  2: string name 
}

service CategoryService {
  Category get(1: i64 id),
  list<Category> getChildren(1: i64 parentId)
}