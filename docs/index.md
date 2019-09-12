---
title: Squire
---
## Work In Progress

This documentation is in the course of being updated from the .NET version to support Java.  Please pardon our dust as we work on these updates.

## Solutions
<ul>
  {% for post in site.posts %}
    <li>
      <a href="{{ post.url | relative_url }}">{{ post.title }}</a>
    </li>
  {% endfor %}
</ul>
