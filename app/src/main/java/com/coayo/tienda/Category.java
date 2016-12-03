package com.coayo.tienda;

public class Category
{
    private String Deleted;

    private String ShowOnHomePage;

    private String Description;

    private String Published;

    private String PriceRanges;

    private String DisplayOrder;

    private String IncludeInTopMenu;

    private String AllowCustomersToSelectPageSize;

    private String PageSize;

    private String UpdatedOnUtc;

    private int CategoryTemplateId;

    private String MetaDescription;

    private String MetaKeywords;

    private String Name;

    private int ParentCategoryId;

    private String PageSizeOptions;

    private String CreatedOnUtc;

    private String SubjectToAcl;

    private String MetaTitle;

    private int Id;

    private int PictureId;

    private String LimitedToStores;
//contructor

    public Category(String Name, String Description, int ParentCategoryId, int Id, int PictureId ){
        this.Name = Name;
        this.Description = Description;
        this.ParentCategoryId = ParentCategoryId;
        this.Id = Id;
        this.PictureId = PictureId;

    };


    public String getDeleted ()
    {
        return Deleted;
    }

    public void setDeleted (String Deleted)
    {
        this.Deleted = Deleted;
    }

    public String getShowOnHomePage ()
    {
        return ShowOnHomePage;
    }

    public void setShowOnHomePage (String ShowOnHomePage)
    {
        this.ShowOnHomePage = ShowOnHomePage;
    }

    public String getDescription ()
{
    return Description;
}

    public void setDescription (String Description)
    {
        this.Description = Description;
    }

    public String getPublished ()
    {
        return Published;
    }

    public void setPublished (String Published)
    {
        this.Published = Published;
    }

    public String getPriceRanges ()
    {
        return PriceRanges;
    }

    public void setPriceRanges (String PriceRanges)
    {
        this.PriceRanges = PriceRanges;
    }

    public String getDisplayOrder ()
    {
        return DisplayOrder;
    }

    public void setDisplayOrder (String DisplayOrder)
    {
        this.DisplayOrder = DisplayOrder;
    }

    public String getIncludeInTopMenu ()
    {
        return IncludeInTopMenu;
    }

    public void setIncludeInTopMenu (String IncludeInTopMenu)
    {
        this.IncludeInTopMenu = IncludeInTopMenu;
    }

    public String getAllowCustomersToSelectPageSize ()
    {
        return AllowCustomersToSelectPageSize;
    }

    public void setAllowCustomersToSelectPageSize (String AllowCustomersToSelectPageSize)
    {
        this.AllowCustomersToSelectPageSize = AllowCustomersToSelectPageSize;
    }

    public String getPageSize ()
    {
        return PageSize;
    }

    public void setPageSize (String PageSize)
    {
        this.PageSize = PageSize;
    }

    public String getUpdatedOnUtc ()
    {
        return UpdatedOnUtc;
    }

    public void setUpdatedOnUtc (String UpdatedOnUtc)
    {
        this.UpdatedOnUtc = UpdatedOnUtc;
    }

    public int getCategoryTemplateId()
    {
        return CategoryTemplateId;
    }

    public void setCategoryTemplateId (int CategoryTemplateId)
    {
        this.CategoryTemplateId = CategoryTemplateId;
    }

    public String getMetaDescription ()
{
    return MetaDescription;
}

    public void setMetaDescription (String MetaDescription)
    {
        this.MetaDescription = MetaDescription;
    }

    public String getMetaKeywords ()
{
    return MetaKeywords;
}

    public void setMetaKeywords (String MetaKeywords)
    {
        this.MetaKeywords = MetaKeywords;
    }

    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    public int getParentCategoryId ()
    {
        return ParentCategoryId;
    }

    public void setParentCategoryId (int ParentCategoryId)
    {
        this.ParentCategoryId = ParentCategoryId;
    }

    public String getPageSizeOptions ()
    {
        return PageSizeOptions;
    }

    public void setPageSizeOptions (String PageSizeOptions)
    {
        this.PageSizeOptions = PageSizeOptions;
    }

    public String getCreatedOnUtc ()
    {
        return CreatedOnUtc;
    }

    public void setCreatedOnUtc (String CreatedOnUtc)
    {
        this.CreatedOnUtc = CreatedOnUtc;
    }

    public String getSubjectToAcl ()
    {
        return SubjectToAcl;
    }

    public void setSubjectToAcl (String SubjectToAcl)
    {
        this.SubjectToAcl = SubjectToAcl;
    }

    public String getMetaTitle ()
{
    return MetaTitle;
}

    public void setMetaTitle (String MetaTitle)
    {
        this.MetaTitle = MetaTitle;
    }

    public int getId ()
    {
        return Id;
    }

    public void setId (int Id)
    {
        this.Id = Id;
    }

    public int getPictureId ()
    {
        return PictureId;
    }

    public void setPictureId (int PictureId)
    {
        this.PictureId = PictureId;
    }

    public String getLimitedToStores ()
    {
        return LimitedToStores;
    }

    public void setLimitedToStores (String LimitedToStores)
    {
        this.LimitedToStores = LimitedToStores;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Deleted = "+Deleted+", ShowOnHomePage = "+ShowOnHomePage+", Description = "+Description+", Published = "+Published+", PriceRanges = "+PriceRanges+", DisplayOrder = "+DisplayOrder+", IncludeInTopMenu = "+IncludeInTopMenu+", AllowCustomersToSelectPageSize = "+AllowCustomersToSelectPageSize+", PageSize = "+PageSize+", UpdatedOnUtc = "+UpdatedOnUtc+", CategoryTemplateId = "+CategoryTemplateId+", MetaDescription = "+MetaDescription+", MetaKeywords = "+MetaKeywords+", Name = "+Name+", ParentCategoryId = "+ParentCategoryId+", PageSizeOptions = "+PageSizeOptions+", CreatedOnUtc = "+CreatedOnUtc+", SubjectToAcl = "+SubjectToAcl+", MetaTitle = "+MetaTitle+", Id = "+Id+", PictureId = "+PictureId+", LimitedToStores = "+LimitedToStores+"]";
    }
}



