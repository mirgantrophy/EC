package com.example.ecenter;

public final class User 
{
    private String role, firstName, lastName, title, email, location, phone, website, bio;
    private char gender;
    private Integer newsletterSubscription;


    public String getEmail()
    {
        return email;
    }

    public void setEmail(final String email) 
    {
        this.email = email;
    }

    public String getLocation() 
    {
        return location;
    }

    public void setLocation(final String location) 
    {
        this.location = location;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(final String phone) 
    {
        this.phone = phone;
    }

    public Integer getNewsletterSubscription() 
    {
        return newsletterSubscription;
    }

    public void setNewsletterSubscription(final Integer newsletterSubscription) 
    {
        this.newsletterSubscription = newsletterSubscription;
    }

    public String getWebsite() 
    {
        return website;
    }

    public void setWebsite(final String website) 
    {
        this.website = website;
    }

    public String getBio() 
    {
        return bio;
    }

    public void setBio(final String bio) 
    {
        this.bio = bio;
    }

    public char getGender() 
    {
        return gender;
    }

    public void setGender(final char gender) 
    {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) 
    {
        this.title = title;
    }

    public String getRole() 
    {
        return role;
    }

    public void setRole(final String role) 
    {
        this.role = role;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public void setFirstName(final String firstName) 
    {
        this.firstName = firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public void setLastName(final String lastName) 
    {
        this.lastName = lastName;
    }

}
